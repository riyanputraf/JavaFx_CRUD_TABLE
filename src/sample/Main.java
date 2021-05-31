package sample;
/**
 * @author Riyan Putra Firjatullah
 * 202010370311328
 * informatic
 */

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {

    public static class Dosen {
        private final SimpleStringProperty name;
        private final SimpleStringProperty mataKuliah;
        private final SimpleStringProperty waktu;
        private final SimpleStringProperty gkb;
        private final SimpleStringProperty ruangan;

        private Dosen(String fName, String fMataKuliah, String fWaktu, String fGKB, String fRuangan) {
            this.name = new SimpleStringProperty(fName);
            this.mataKuliah = new SimpleStringProperty(fMataKuliah);
            this.waktu = new SimpleStringProperty(fWaktu);
            this.gkb = new SimpleStringProperty(fGKB);
            this.ruangan = new SimpleStringProperty(fRuangan);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String fName) {
            name.set(fName);
        }

        public String getMatakuliah() {
            return mataKuliah.get();
        }

        public void setMataKuliah(String fName) {
            mataKuliah.set(fName);
        }

        public String getWaktu() {
            return waktu.get();
        }

        public void setWaktu(String fName) {
            waktu.set(fName);
        }

        public String getGkb() {
            return gkb.get();
        }

        public void setGKB(String fName) {
            gkb.set(fName);
        }

        public String getRuangan() {
            return ruangan.get();
        }

        public void setRuangan(String fName) {
            ruangan.set(fName);
        }


    }


    final ObservableList<Dosen> data = FXCollections.observableArrayList(
            new Dosen("Nama Dosen", "Matematika Diskrit", "07.00", "2", "13")
    );

    private int selectedIndex;
    TableView<Dosen> table = new TableView<Dosen>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Jadwal Kuliah");
        Scene scene = new Scene(new Group());
        Button Submit = new Button("Lihat Jadwal");


        Scene scene2 = new Scene(new Group());
        final Label label = new Label("Jadwal Kuliah");
        label.setFont(new Font("Arial", 20));
        table.setEditable(true);

        table.setOnMouseClicked(event -> {
            selectedIndex = table.getSelectionModel().getSelectedIndex();
        });


        Button deleteBtn = new Button("Delete");
        deleteBtn.setOnAction((ActionEvent e) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Deleting Schedule");
            alert.setHeaderText("Deleting Schedule From Table");
            alert.setContentText("Are you sure want to delete?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                data.remove(selectedIndex);
            } else {
                alert.close();
            }

        });


        TableColumn name_m = new TableColumn("Nama");

        name_m.setMinWidth(200);
        name_m.setCellValueFactory(
                new PropertyValueFactory<Dosen, String>("name"));
        name_m.setCellFactory(TextFieldTableCell.forTableColumn());
        name_m.setOnEditCommit(
                new EventHandler<CellEditEvent<Dosen, String>>() {
                    @Override
                    public void handle(CellEditEvent<Dosen, String> t) {
                        ((Dosen) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setName(t.getNewValue());
                    }
                }
        );
        //
        TableColumn matklh = new TableColumn("Mata Kuliah");
        matklh.setMinWidth(200);
        matklh.setCellValueFactory(
                new PropertyValueFactory<Dosen, String>("matakuliah"));
        matklh.setCellFactory(TextFieldTableCell.forTableColumn());
        matklh.setOnEditCommit(
                new EventHandler<CellEditEvent<Dosen, String>>() {
                    @Override
                    public void handle(CellEditEvent<Dosen, String> t) {
                        ((Dosen) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setMataKuliah(t.getNewValue());
                    }
                }
        );
        //

        TableColumn waktu_m = new TableColumn("Waktu");

        waktu_m.setMinWidth(200);
        waktu_m.setCellValueFactory(
                new PropertyValueFactory<Dosen, String>("waktu"));
        waktu_m.setCellFactory(TextFieldTableCell.forTableColumn());
        waktu_m.setOnEditCommit(
                new EventHandler<CellEditEvent<Dosen, String>>() {
                    @Override
                    public void handle(CellEditEvent<Dosen, String> t) {
                        ((Dosen) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setWaktu(t.getNewValue());
                    }
                }
        );

        TableColumn ngkb = new TableColumn("GKB");
        ngkb.setMinWidth(200);
        ngkb.setCellValueFactory(
                new PropertyValueFactory<Dosen, String>("gkb"));
        ngkb.setCellFactory(TextFieldTableCell.forTableColumn());
        ngkb.setOnEditCommit(
                new EventHandler<CellEditEvent<Dosen, String>>() {
                    @Override
                    public void handle(CellEditEvent<Dosen, String> t) {
                        ((Dosen) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setGKB(t.getNewValue());
                    }
                }
        );


        TableColumn ruangan_m = new TableColumn("Ruangan");

        ruangan_m.setMinWidth(200);
        ruangan_m.setCellValueFactory(
                new PropertyValueFactory<Dosen, String>("Ruangan"));
        ruangan_m.setCellFactory(TextFieldTableCell.forTableColumn());
        ruangan_m.setOnEditCommit(
                new EventHandler<CellEditEvent<Dosen, String>>() {
                    @Override
                    public void handle(CellEditEvent<Dosen, String> t) {
                        ((Dosen) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setRuangan(t.getNewValue());
                    }
                }
        );


        table.setItems(data);
        Button back = new Button("Back");
        table.getColumns().addAll(name_m, matklh, waktu_m, ngkb, ruangan_m);

        // halaman 1 input data dosen
        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(new Font("Arial", 20));
        GridPane grid = new GridPane();
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label nama = new Label("Nama");
        grid.add(nama, 0, 1);
        final TextField addName = new TextField();
        addName.setPromptText("Nama Dosen");
        //addName.setMaxWidth(name_m.getPrefWidth());
        grid.add(addName, 1, 1);
        grid.setHgap(10);


        Label matkul = new Label("Mata Kuliah");
        grid.add(matkul, 0, 2);
        final TextField addMataKuliah = new TextField();
        //addMataKuliah.setMaxWidth(matklh.getPrefWidth());
        addMataKuliah.setPromptText("Mata Kuliah");
        grid.add(addMataKuliah, 1, 2);
        grid.setVgap(10);

        Label time = new Label("Waktu");
        grid.add(time, 0, 3);
        final TextField addWaktu = new TextField();
        //addWaktu.setMaxWidth(waktu_m.getPrefWidth());
        addWaktu.setPromptText("Waktu");
        grid.add(addWaktu, 1, 3);

        Label gedung = new Label("GKB");
        grid.add(gedung, 0, 4);
        final TextField addGKB = new TextField();
        //addGKB.setMaxWidth(ngkb.getPrefWidth());
        addGKB.setPromptText("GKB");
        grid.add(addGKB, 1, 4);


        Label tempat = new Label("Ruangan");
        grid.add(tempat, 0, 5);
        final TextField addRuangan = new TextField();
        //addRuangan.setMaxWidth(ruangan_m.getPrefWidth());
        addRuangan.setPromptText("Ruangan");
        grid.add(addRuangan, 1, 5);

        final Button addButton = new Button("Tambah Jadwal");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                if (addName.getText().isEmpty() || addMataKuliah.getText().isEmpty() || addWaktu.getText().isEmpty()
                        || addGKB.getText().isEmpty() || addRuangan.getText().isEmpty())
                {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("You must fill in all the data provided");

                    alert.showAndWait();
                } else
                {
                    data.add(new Dosen(
                            addName.getText(),
                            addMataKuliah.getText(),
                            addWaktu.getText(),
                            addGKB.getText(),
                            addRuangan.getText()


                    ));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("New Schedule");
                    alert.setHeaderText(null);
                    alert.setContentText("Create new Schedule has been succses!");

                    alert.showAndWait();
                }


                addName.clear();
                addMataKuliah.clear();
                addWaktu.clear();
                addGKB.clear();
                addRuangan.clear();
            }
        });

        final VBox vb = new VBox();
        vb.setSpacing(20);

        vb.setPadding(new Insets(200, 100, 100, 100));
        //vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(grid, Submit, addButton);


        ((Group) scene.getRoot()).getChildren().addAll(vb);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, back, deleteBtn);

        ((Group) scene2.getRoot()).getChildren().addAll(vbox);


        Submit.setOnAction(e ->
        {
            primaryStage.setScene(scene2);
        });

        back.setOnAction((e -> {
            primaryStage.setScene(scene);
        }));


        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
