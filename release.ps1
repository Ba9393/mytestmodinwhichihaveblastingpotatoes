param(
    [Parameter(Mandatory=$true)]
    [string]$version
)

# Build the mod locally
Write-Host "Building mod..."
.\gradlew.bat build

if ($LASTEXITCODE -ne 0) {
    Write-Error "Build failed. Exiting."
    exit 1
}

# Stage all changes
git add .

# Commit with the version message
git commit -m "Build and release version $version"

# Push to remote
git push

# Create a git tag for the release version and push it
git tag "v$version"
git push origin "v$version"

# Create a GitHub release with all .jar files in build/libs/
Write-Host "Creating GitHub release for version v$version..."
gh release create "v$version" ./build/libs/*.jar --title "Release v$version" --notes "Automated release of version $version"

Write-Host "Release process complete!"
