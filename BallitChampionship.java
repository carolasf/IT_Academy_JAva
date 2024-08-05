import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
package ballitchampionship;


public class BallitChampionship {
    private List<Team> teams = new ArrayList<>();
    private static final int MAX_TEAMS = 16;
    private static final int MIN_TEAMS = 8;

    // Classe interna para representar um time
    class Team {
        String name;
        String chant;
        int foundingYear;

        Team(String name, String chant, int foundingYear) {
            this.name = name;
            this.chant = chant;
            this.foundingYear = foundingYear;
        }
    }

    public void addTeam(String name, String chant, int foundingYear) {
        if (teams.size() >= MAX_TEAMS) {
            System.out.println("Erro: O número máximo de times (16) já foi atingido.");
            return;
        }
        for (Team team : teams) {
            if (team.name.equals(name)) {
                System.out.println("Erro: O time com o nome '" + name + "' já está cadastrado.");
                return;
            }
        }
        teams.add(new Team(name, chant, foundingYear));
        System.out.println("Time '" + name + "' cadastrado com sucesso.");
    }

    public boolean validateTeams() {
        int numTeams = teams.size();
        if (numTeams < MIN_TEAMS) {
            System.out.println("Erro: O número mínimo de times (8) não foi atingido.");
            return false;
        }
        if (numTeams % 2 != 0) {
            System.out.println("Erro: O número de times deve ser par.");
            return false;
        }
        return true;
    }

    public void displayTeams() {
        if (teams.isEmpty()) {
            System.out.println("Nenhum time cadastrado.");
        } else {
            System.out.println("Times cadastrados:");
            for (Team team : teams) {
                System.out.println("Nome: " + team.name + ", Grito de Guerra: " + team.chant + ", Ano de Fundação: " + team.foundingYear);
            }
        }
    }

    public static void main(String[] args) {
        BallitChampionship championship = new BallitChampionship();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de times para o Campeonato de BALLIT");
        while (championship.teams.size() < MAX_TEAMS) {
            System.out.print("Nome do time: ");
            String name = scanner.nextLine();
            System.out.print("Grito de guerra: ");
            String chant = scanner.nextLine();
            System.out.print("Ano de fundação: ");
            int foundingYear = Integer.parseInt(scanner.nextLine());

            championship.addTeam(name, chant, foundingYear);

            System.out.println("Deseja cadastrar outro time? (s/n)");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("s")) {
                break;
            }
        }

        if (championship.validateTeams()) {
            championship.displayTeams();
        } else {
            System.out.println("A validação dos times falhou.");
        }

        scanner.close();
    }
}
