import SistemaBatch.controller.jobs.JobEnviarEmail;

public class PrincipalBatch {
    public static void main(String[] args) {
        new JobEnviarEmail().start();
    }
}
