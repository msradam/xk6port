# xk6port

[![Build and Test](https://github.com/zopencommunity/xk6port/actions/workflows/build_and_test.yml/badge.svg)](https://github.com/zopencommunity/xk6port/actions/workflows/build_and_test.yml)

z/OS port of [xk6](https://github.com/grafana/xk6), the custom k6 builder that enables building k6 with extensions.

xk6 lets you compile custom k6 binaries with one or more extensions baked in. This is useful for adding protocol support (e.g., gRPC, AMQP, TN3270) or output backends (e.g., Prometheus, Datadog) to k6.

## Installation

```bash
zopen install xk6
```

## Building from Source

```bash
git clone https://github.com/zopencommunity/xk6port.git
cd xk6port
zopen build
```

### Prerequisites

- [zopen](https://github.com/zopencommunity/meta) framework installed
- Go toolchain for z/OS (`zopen install go`)
- git (`zopen install git`)

## Usage

Build a custom k6 binary with extensions:

```bash
# Build k6 with a specific extension
xk6 build --with github.com/grafana/xk6-output-prometheus-remote

# Build k6 with a specific k6 version
xk6 build v1.5.0 --with github.com/grafana/xk6-output-prometheus-remote

# Build k6 with multiple extensions
xk6 build --with github.com/grafana/xk6-output-prometheus-remote --with github.com/grafana/xk6-dashboard
```

### z/OS Notes

When building extensions on z/OS, xk6 will cross-compile for `GOOS=zos GOARCH=s390x` automatically if your Go environment is configured for z/OS. If you encounter encoding issues, ensure your Go source files are tagged as UTF-8:

```bash
chtag -tc 1208 *.go go.mod go.sum
```

Some extensions may require additional patches for z/OS compatibility, particularly those that use OS-specific filesystem or network APIs.

## About

This repository provides the zopen build configuration and z/OS-specific patches needed to compile xk6 for z/OS (`GOOS=zos`, `GOARCH=s390x`). It wraps the upstream [grafana/xk6](https://github.com/grafana/xk6) release.

## Related Ports

- [k6port](https://github.com/zopencommunity/k6port) - k6 load testing tool for z/OS

## License

xk6 is licensed under the [Apache License 2.0](LICENSE.md).
