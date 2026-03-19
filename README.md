# xk6port

z/OS port of [xk6](https://github.com/grafana/xk6), the custom k6 builder that enables building k6 with extensions.

## Installation

```bash
zopen install xk6
```

## Building from Source

```bash
git clone https://github.com/msradam/xk6port.git
cd xk6port
zopen build
```

### Troubleshooting

If `zopen build` fails immediately with an encoding error, buildenv may have been checked out with a UTF-8 tag. Fix it with:

```bash
iconv -f UTF-8 -t IBM-1047 buildenv > /tmp/b && mv /tmp/b buildenv && chtag -r buildenv
```

## About

This repository provides the zopen build configuration and z/OS-specific patches needed to compile xk6 for z/OS (GOOS=zos, GOARCH=s390x). It wraps the upstream [grafana/xk6](https://github.com/grafana/xk6) v1.3.6 release.
