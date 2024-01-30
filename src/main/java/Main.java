
//Importation des bibliotheques requises

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    //Fonction principale
    public static void main(String[] args) throws IOException {

        String tifImagePath = "/Users/fabricefoko/Documents/Projets_JAVA/ecom-project/script/output_image.tif";
        String outputDir = "/Users/fabricefoko/Documents/Projets_JAVA/ecom-project/script/";
        String outputImageName = "output_image.jpg";

        File condorSubmitFile = generateCondorSubmitFile(tifImagePath, outputDir, outputImageName);

    }

    // Fonction qui génère le contenu du fichier de soumission HTCondor dans OutPutdir
    private static File generateCondorSubmitFile(String tifImagePath, String outputDir, String outputImageName) throws IOException {


        // Nom du fichier de soumission HTCondor
        String submitFileName = "test.submit";

        // Chemin complet du fichier de soumission HTCondor
        File condorSubmitFile = new File(outputDir, submitFileName);

        // Vérifier si le fichier existe déjà
        if (condorSubmitFile.exists()) {
            // Le fichier existe déjà, vous pouvez gérer cela selon vos besoins
            System.out.println("Le fichier de soumission HTCondor existe déjà : " + condorSubmitFile.getAbsolutePath());

        } else {
            // Le fichier n'existe pas, vous pouvez le créer
            try (FileWriter writer = new FileWriter(condorSubmitFile)) {
                // Contenu du fichier de soumission HTCondor
                String content = "executable = /Users/fabricefoko/Documents/Projets_JAVA/ecom-project/script/convert_image.sh\n" +
                        "arguments = " + tifImagePath + " " + outputDir + " " + outputImageName + "\n" +
                        "output = " + outputDir + "convert_output.txt\n" +
                        "error = " + outputDir + "convert_error.txt\n" +
                        "log = " + outputDir + "convert_log.txt\n" +
                        "queue";
                writer.write(content);
            }

            System.out.println("Le fichier de soumission HTCondor a été généré : " + condorSubmitFile.getAbsolutePath());
        }
        return condorSubmitFile;
    }

}
