#!/bin/bash

echo "Deleting All class Files"

# The 'find' command looks in the current directory (.) and all subdirectories
# -type f means look for files
# -name "*.class" means look for files ending in .class
# -delete removes them instantly
find . -type f -name "*.class" -delete

echo "Cleanup complete! All .class files have been removed."