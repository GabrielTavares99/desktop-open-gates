package SistemaBatch;

import SistemaBatch.controller.jobs.JobEnviarEmail;

public class SistemaBatch {
    public static void main(String[] args) {
        new JobEnviarEmail().start();
    }
}
