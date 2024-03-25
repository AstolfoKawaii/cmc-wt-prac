#!/bin/bash

set -e

pushd "$(dirname -- "$0")"

podman run --rm -d \
    --network host \
    --name cmc-wt-pgsql \
    -e POSTGRES_PASSWORD=123 \
    -e POSTGRES_DB=books \
    docker.io/library/postgres:14

sleep 10

podman exec -i cmc-wt-pgsql bash -c 'cat > /tmp/create.sql' < ./create.sql
podman exec -i --user postgres cmc-wt-pgsql psql -f /tmp/create.sql

popd