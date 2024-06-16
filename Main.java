public class Main {
    public static void main(String[] args) {
        // Criação do simulador de sistema de arquivos
        FileSystemSimulator fs = new FileSystemSimulator();

        // Criação de diretórios
        System.out.println("Criando diretórios...");
        fs.createDirectory("/home");
        fs.createDirectory("/home/user");
        fs.createDirectory("/home/user/docs");

        // Criação de arquivos
        System.out.println("Criando arquivos...");
        fs.createFile("/home/user/file1.txt");
        fs.createFile("/home/user/file2.txt");
        fs.createFile("/home/user/docs/doc1.txt");

        // Listar conteúdo do diretório /home
        System.out.println("\nConteúdo do diretório /home:");
        fs.listDirectory("/home");

        // Renomear arquivo
        System.out.println("\nRenomeando arquivo...");
        fs.renameFileOrDirectory("/home/user/file1.txt", "/home/user/file1_renamed.txt");

        // Copiar arquivo
        System.out.println("\nCopiando arquivo...");
        fs.copyFile("/home/user/file2.txt", "/home/user/file2_copy.txt");

        // Listar conteúdo do diretório /home/user
        System.out.println("\nConteúdo do diretório /home/user:");
        fs.listDirectory("/home/user");

        // Apagar arquivo
        System.out.println("\nApagando arquivo...");
        fs.deleteFile("/home/user/file2_copy.txt");

        // Apagar diretório
        System.out.println("\nApagando diretório...");
        fs.deleteDirectory("/home/user/docs");

        // Listar conteúdo do diretório /home/user após exclusões
        System.out.println("\nConteúdo do diretório /home/user após exclusões:");
        fs.listDirectory("/home/user");

        // Mostrar journal de operações
        System.out.println("\nJournal de operações:");
        fs.showJournal();
    }
}
