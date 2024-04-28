package relojconalarma;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class RelojConAlarma extends JPanel {

    private JLabel label; // JLabel para mostrar la hora actual
    private LocalTime horaActual; // Objeto para almacenar la hora actual
    private DateTimeFormatter formatter; // Formateador de fecha y hora
    private JButton alarmaBtn; // Botón para configurar la alarma
    private String message; // Mensaje de la alarma
    
    private LocalTime tiempoAlarma; // Hora programada para la alarma

    public RelojConAlarma() {
        // Método de inicialización
        initComponents();
        // Método para establecer eventos
        setEvents();

        // Creación de un temporizador para actualizar la hora cada segundo
        Timer timer = new Timer();
        timer.schedule(
                new TimerTask() {
            @Override
            public void run() {
                // Actualizar la hora actual
                horaActual = LocalTime.now();
                // Mostrar la hora actual en el JLabel
                label.setText(String.valueOf(horaActual.format(formatter)));
                
                // Imprimir la hora actual en la consola
                System.out.println("Hora actual: " + horaActual.format(formatter));

                // Verificar si la alarma está configurada y si coincide con la hora actual
                if (tiempoAlarma != null) {
                    // Imprimir la hora de la alarma en la consola
                    System.out.println("Hora Alarma: " + tiempoAlarma.format(formatter));
                    // Si la hora de la alarma coincide con la hora actual, mostrar un mensaje de alarma
                    if (tiempoAlarma.format(formatter).equals(horaActual.format(formatter))) {
                        new alarmaMessage(null, true, message).setVisible(true);
                        tiempoAlarma = null; // Reiniciar la hora de la alarma
                    }
                }
            }
        },
                0, // Retraso inicial de 0 milisegundos
                1000); // Temporizador que se ejecuta cada 1000 milisegundos (1 segundo)
    }

    // Método para inicializar los componentes de la interfaz
    private void initComponents() {
        tiempoAlarma = null; // Inicializar la hora de la alarma como nula
        message = "Es Hora"; // Mensaje por defecto de la alarma
        formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // Establecer el formato de la hora
        
        // Establecer el diseño del panel como GridBagLayout
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Crear un JLabel para mostrar la hora actual
        label = new JLabel();
        // Crear un borde con relleno solo en el lado derecho
        Border bordeConPadding = BorderFactory.createEmptyBorder(0, 0, 0, 5);
        // Establecer el borde con relleno en el JLabel
        label.setBorder(bordeConPadding);
        // Establecer la posición del JLabel en la cuadrícula
        gbc.gridx = 0;
        gbc.gridy = 0;
        // Agregar el JLabel al panel
        this.add(label, gbc);

        // Crear un JButton para configurar la alarma
        alarmaBtn = new JButton();
        alarmaBtn.setSize(90, 20);
        alarmaBtn.setText("Alarma");
        // Establecer la posición del JButton en la cuadrícula
        gbc.gridx = 1;
        gbc.gridy = 0;
        // Agregar el JButton al panel
        this.add(alarmaBtn, gbc);
    }

    // Método para establecer eventos
    private void setEvents() {
        // Agregar un MouseListener al JButton de la alarma
        alarmaBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Mostrar una ventana para configurar la alarma cuando se hace clic en el botón
                new setAlarma(null, true, RelojConAlarma.this).setVisible(true);
            }
        });
    }

    // Getter para el formateador de fecha y hora
    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    // Getter para la hora de la alarma
    public LocalTime getTiempoAlarma() {
        return tiempoAlarma;
    }

    // Setter para la hora de la alarma
    public void setTiempoAlarma(LocalTime tiempoAlarma) {
        this.tiempoAlarma = tiempoAlarma;
    }

    // Getter para el mensaje de la alarma
    public String getMessage() {
        return message;
    }

    // Setter para el mensaje de la alarma
    public void setMessage(String message) {
        this.message = message;
    }

}
