#!/usr/bin/env bash
# ------------------------------------------------------------
# Grafana 자동 셋업 스크립트 (Section 11 대시보드)
#
# 하는 일:
#   1. Grafana(3000)가 떠 있는지 확인
#   2. Prometheus 데이터소스를 uid="prometheus"로 등록 (이미 있으면 갱신)
#   3. dashboards/k6-load-test-dashboard.json 을 임포트
#
# 사전 조건: Grafana 실행 중 (brew services start grafana)
# 기본 계정: admin / admin
# ------------------------------------------------------------
set -euo pipefail

GRAFANA_URL="${GRAFANA_URL:-http://localhost:3000}"
GRAFANA_AUTH="${GRAFANA_AUTH:-admin:admin}"
PROM_URL="${PROM_URL:-http://localhost:9090}"
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
DASHBOARD_FILE="${SCRIPT_DIR}/dashboards/k6-load-test-dashboard.json"

echo "==> Grafana 상태 확인: ${GRAFANA_URL}"
if ! curl -sf -o /dev/null "${GRAFANA_URL}/api/health"; then
  echo "    [에러] Grafana가 응답하지 않는다. 먼저 'brew services start grafana' 실행해라." >&2
  exit 1
fi

echo "==> Prometheus 데이터소스 등록 (uid=prometheus)"
DS_PAYLOAD=$(cat <<JSON
{
  "uid": "prometheus",
  "name": "Prometheus",
  "type": "prometheus",
  "access": "proxy",
  "url": "${PROM_URL}",
  "isDefault": true
}
JSON
)
# 이미 있으면 409 → PUT으로 갱신
if curl -sf -u "${GRAFANA_AUTH}" -H "Content-Type: application/json" \
     -X POST "${GRAFANA_URL}/api/datasources" -d "${DS_PAYLOAD}" -o /dev/null; then
  echo "    데이터소스 신규 생성 완료"
else
  curl -sf -u "${GRAFANA_AUTH}" -H "Content-Type: application/json" \
     -X PUT "${GRAFANA_URL}/api/datasources/uid/prometheus" -d "${DS_PAYLOAD}" -o /dev/null
  echo "    데이터소스 이미 존재 → 갱신 완료"
fi

echo "==> 대시보드 임포트: ${DASHBOARD_FILE}"
IMPORT_PAYLOAD=$(python3 - "${DASHBOARD_FILE}" <<'PY'
import json, sys
with open(sys.argv[1]) as f:
    model = json.load(f)
model["id"] = None
print(json.dumps({"dashboard": model, "overwrite": True, "folderId": 0}))
PY
)
RESP=$(curl -sf -u "${GRAFANA_AUTH}" -H "Content-Type: application/json" \
   -X POST "${GRAFANA_URL}/api/dashboards/db" -d "${IMPORT_PAYLOAD}")
echo "    임포트 응답: ${RESP}"

echo ""
echo "==> 완료. 대시보드 열기:"
echo "    ${GRAFANA_URL}/d/k6-popular-shop"
