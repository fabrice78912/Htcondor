#!/bin/bash

# Define paths
new_folder="/Users/fabricefoko/Documents/Projets_JAVA/Htcondor"
backup_folder_base="/Users/fabricefoko/Documents/backup"

# Generate a backup folder name with the format "condor-DateOfDay"
backup_folder="condor-$(date +'%Y%m%d%H%M%S')"

# Full paths
new_folder_path="$new_folder"
backup_folder_path="$backup_folder_base/$backup_folder"

# Check if backup folder exists
if [ -d "$backup_folder_path" ]; then
  echo "Deleting existing backup folder: $backup_folder_path"
  rm -rf "$backup_folder_path"
fi

# Create a new backup
echo "Creating a new backup: $backup_folder_path"
cp -r "$new_folder_path" "$backup_folder_path"

echo "Backup completed successfully."
