#!/bin/bash

set -e


pushd "$(dirname -- "$0")"

podman exec -i cmc-wt-pgsql bash -c 'cat > /tmp/demo.sql' < ./demo.sql
podman exec -i --user postgres cmc-wt-pgsql psql -f /tmp/demo.sql

popd
