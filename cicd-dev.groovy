node('go_1258') {
  stage('Build') {
    build job: 'Port-Pipeline',
    parameters: [
      string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/msradam/xk6port.git'),
      string(name: 'PORT_DESCRIPTION', value: 'xk6 custom k6 builder for z/OS'),
      string(name: 'BUILD_LINE', value: 'DEV'),
      string(name: 'NODE_LABEL', value: 'go_1258')
    ]
  }
}
