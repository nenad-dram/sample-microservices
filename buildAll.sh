# Build all modules
./mvnw clean package

# Extract fat jars (within target/layers)
for dir in *-service; do
  echo "Extract: $dir"
  mkdir -p $dir/target/layers && (cd $dir/target/layers; jar -xf ../*.jar)
done
