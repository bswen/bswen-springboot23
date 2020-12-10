echo "start build $1 with repo $2, click to start ..."
read
./gradlew $1:build
echo "build $1 ok, click to start expload jars..."
read
cd $1/bin
./expload-deps.sh
echo "deps exploaded, click to start build docker..."
read
./docker-build.sh $2
echo "docker build ok, click to start push docker images..."
read
docker push $2/spring/$1:latest
echo "docker image pushed ok,click to start deploy to k8s..."
read
cd ..
kubectl apply -f k8s/deployment.yaml
echo 'k8s deploy complete. All done.'

