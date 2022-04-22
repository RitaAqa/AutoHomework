public class Requests {
    public static void main(String args[]) {
        GetRequests getRequests = new GetRequests();
        try {
            getRequests.setIdentificationToken();
            getRequests.getFilesFromRootFolder();
            getRequests.getFilesFromSpecificFolder();
            getRequests.getFilesCount();
            getRequests.getGetRuns();
            getRequests.getGetAnalyses();
            getRequests.getGetArtifacts();
        }
        catch (NullPointerException ex) {
            System.out.println("Cannot set token");
            ex.printStackTrace();
        }
    }
}
