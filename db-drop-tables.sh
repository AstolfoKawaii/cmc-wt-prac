#!/bin/bash

set -e

pushd "$(dirname -- "$0")"

podman stop cmc-wt-pgsql

popd