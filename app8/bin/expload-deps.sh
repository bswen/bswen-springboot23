#rm -rf ../build/dependency/*
mkdir -p ../build/dependency && (cd ../build/dependency; jar -xf ../libs/*.jar)
