#!/bin/bash

# Vérifier le nombre d'arguments
if [ "$#" -ne 2 ]; then
    echo "Usage: $0 input.tif output.jpg"
    exit 1
fi

# Définir les noms de fichiers d'entrée et de sortie
input_file="$1"
output_file="$2"

# Vérifier si le fichier d'entrée existe
if [ ! -f "$input_file" ]; then
    echo "Erreur : le fichier d'entrée '$input_file' n'existe pas."
    exit 1
fi

# Utiliser ImageMagick pour convertir l'image
convert "$input_file" "$output_file"

# Vérifier si la conversion a réussi
if [ $? -eq 0 ]; then
    echo "Conversion réussie : $input_file -> $output_file"
else
    echo "Erreur lors de la conversion de l'image."
fi
