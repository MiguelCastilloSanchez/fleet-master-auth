pipeline {
  agent any

  environment {
    IMAGE_NAME = "fleet_master_auth_project"
    SERVICE_NAME = "fleet_master_auth"
    GH_TOKEN = credentials("github-token")
    BUILD_ID = "{env.BUILD_ID}"
  }

  stages {
    stage('Compilar proyecto con Maven') {
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }

    stage('Construir imagen Docker') {
      steps {
        sh 'docker build -t ${IMAGE_NAME}:${BUILD_ID} .'
      }
    }

    stage ('Delivery'){
        steps{
            sh '''
                rm -rf fleet-master-deployment
                git clone https://x-access-token:${GH_TOKEN}@github.com/diegoalamilla/fleet-master-deployment.git
                cd fleet-master-deployment

                sed -i "s/^FLEET_AUTH_BUILD_ID=.*/FLEET_AUTH_BUILD_ID=${BUILD_ID}/" .env

                git config user.name "Jenkins[bot]"
                git config user.email "jenkins[bot]@fleetmaster.com"

                git remote set-url origin https://x-access-token:${GH_TOKEN}@github.com/diegoalamilla/fleet-master-deployment.git

                git add .env
                git commit -m "chore: update ${IMAGE_NAME} image to ${BUILD_ID}" || true
                git push origin main
            '''
        }
    
  }

  }

  

  post {
    success {
      echo "Build e imagen ${IMAGE_NAME}:${BUILD_ID} creada correctamente."
      echo "Delivery hecho correctamente"
    }
    failure {
      echo "Fallo en el build."
    }
  }
}
