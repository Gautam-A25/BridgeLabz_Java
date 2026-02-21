package designpattern;

interface FileService {
    void accessFile();
}

class RealFileService implements FileService {
    public void accessFile() {
        System.out.println("Accessing File...");
    }
}

class FileAccessProxy implements FileService {

    private String role;
    private RealFileService realService;

    public FileAccessProxy(String role) {
        this.role = role;
        this.realService = new RealFileService();
    }

    public void accessFile() {
        if (role.equalsIgnoreCase("ADMIN")) {
            realService.accessFile();
        } else {
            System.out.println("Access Denied!");
        }
    }
}

public class ProxyDemo {
    public static void main(String[] args) {

        FileService admin = new FileAccessProxy("ADMIN");
        admin.accessFile();

        FileService user = new FileAccessProxy("USER");
        user.accessFile();
    }
}