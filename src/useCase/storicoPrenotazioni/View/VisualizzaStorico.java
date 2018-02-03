package useCase.storicoPrenotazioni.View;

import exceptions.InsertYearException;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import useCase.storicoPrenotazioni.Model.PrenotazioneStorico;
import java.util.Date;


public class VisualizzaStorico extends Application {

    // Inizializzazione degli elementi grafici
    private Button button = new Button ("CONFERMA");
    private Label labelError = new Label("Cerca prenotazioni");
    private Label labelAnno = new Label("/ 2018");

    // TableView per le prenotazioni
    private TableView tableView = new TableView();
    private TableColumn aula = new TableColumn("Aula");
    private TableColumn evento = new TableColumn("Evento");
    private TableColumn data = new TableColumn("Data");
    private TableColumn oraInizio = new TableColumn("Ora Inizio");
    private TableColumn oraFine = new TableColumn("Ora Fine");


    private ComboBox<String> annoAccademico = new ComboBox<>();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Visualizza storico");
        Scene scene = new Scene(new Group(), 850, 670);

        // Formattazione dei valori degli elementi grafici
        // ComboBox per l'anno accademico
        annoAccademico.getItems().addAll("2017","2018","2019","2020","2021");
        annoAccademico.setPromptText("2017");
        annoAccademico.setEditable(true);


        // TableView per le prenotazioni
        aula.setCellValueFactory(new PropertyValueFactory<PrenotazioneStorico,String>("nomeAula"));
        evento.setCellValueFactory(new PropertyValueFactory<PrenotazioneStorico,String>("titoloEvento"));
        data.setCellValueFactory(new PropertyValueFactory<PrenotazioneStorico,Date>("data"));
        oraInizio.setCellValueFactory(new PropertyValueFactory<PrenotazioneStorico,String>("oraInizio"));
        oraFine.setCellValueFactory(new PropertyValueFactory<PrenotazioneStorico,String>("oraFine"));

        tableView.getColumns().addAll(aula, evento, data, oraInizio, oraFine);


        // Controllo del bottone
        button.setOnAction(e -> {
            try {
                registra();
                if (StoricoBean.anno < 2000 || StoricoBean.anno > 2100) {
                    errorAnno();
                    throw new InsertYearException();
                }
                else
                    mostraPrenotazioni();

            } catch (InsertYearException e1) {
                e1.printStackTrace();
            }
        });

        // Inserimento dell'immagine
        Image image = new Image("Image\\logo.png");
        ImageView imgView = new ImageView(image);
        imgView.setFitHeight(150);
        imgView.setFitWidth(150);

        // Posizionamento degli elementi grafici su un GridPane
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new javafx.scene.control.Label("Anno accademico"),5,10);

        grid.add(annoAccademico, 5,15);
        grid.add(labelAnno, 6, 15);

        grid.add(tableView, 2,20);


        grid.add(labelError, 5,20);
        grid.add(button, 6, 20);
        grid.add(imgView, 2, 15);

        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }

    private void creaAnno(){
        String anno = annoAccademico.getValue();
        if(anno == null)
            anno = "2017";
        StoricoBean.setAnnoAccademico(Integer.parseInt(anno));
        int anno2 = Integer.parseInt(anno)+1;
        labelAnno.setText(" / " + String.valueOf(anno2));
    }

    private void registra(){
        creaAnno();
    }

    private void errorAnno(){
        ObservableList<PrenotazioneStorico> error = null;
        labelError.setText("Errore inserimento anno");
        labelAnno.setText(" !!! ");
        tableView.setItems(error);
    }

    private void mostraPrenotazioni(){
        ObservableList<PrenotazioneStorico> listForTable = StoricoBean.setTable();
        if(listForTable.size() == 0){
            labelError.setText("Non ci sono prenotazioni");
        } else {
            labelError.setText("Cerca prenotazioni");
        }
        tableView.setItems(listForTable);
    }

}
