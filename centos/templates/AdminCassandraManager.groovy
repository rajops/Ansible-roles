job('DSLAdminCassandraManager') {
  description('Cassandra Manager')
     scm {
     git {
      remote {
        url("git@gitlab.com:prontoitlabs/mobiadz-devops.git")
      }
      branch("*/master")
     }
   }


  steps {
        shell(
       	'#!/bin/bash\n'+ 
		'devIntServer="35.154.128.247"\n'+
			'ssh -o StrictHostKeyChecking=no centos@${devIntServer} "docker rm -f cassandra || true ; docker run --restart always -p 9042:9042 --name cassandra -d cassandra:3.7"\n'
			)
    }
}
