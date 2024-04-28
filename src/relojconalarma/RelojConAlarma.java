package relojconalarma;



import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;


public class RelojConAlarma extends JLabel {
    private int ValorInicial = 5;
    private LocalTime horaActual;
    private DateTimeFormatter formatter;
    private JButton alarmaBtn;
    private String message;
    
    private LocalTime tiempoAlarma;



    public RelojConAlarma() {
        
        initComponents();
        setEvents();
        
        
        
        Timer timer = new Timer();

        timer.schedule(
                new TimerTask() {


                    @Override
                    public void run() {
                        horaActual = LocalTime.now();
                        RelojConAlarma.this.setText(String.valueOf(horaActual.format(formatter)));
                        
                        System.out.println("Hora actual: "+horaActual.format(formatter));
                        System.out.println("Hora Alarma: "+tiempoAlarma);
                        
                        if(tiempoAlarma != null && tiempoAlarma.toString().equals(horaActual.format(formatter))){
                            
                            new alarmaMessage(null,true,message).setVisible(true);
                            tiempoAlarma = null;
                            
                        }



                    }
                },
                0, // Això és B (retras de 0 milisegons)
                1000); // Això és C (el timer task s'executa cada 1000 milisegons, és a dir, cada segon.
    }
    
    
    private void initComponents(){
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        tiempoAlarma = null;
        message = "Es Hora";
        
        formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        alarmaBtn = new JButton();
        alarmaBtn.setSize(90, 20);
        alarmaBtn.setText("Alarma");
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(alarmaBtn,gbc);
        //alarmaBtn.setVisible(true);
    }
    
    private void setEvents(){
        
        alarmaBtn.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e){
                new setAlarma(null,true,RelojConAlarma.this).setVisible(true);
                
            }
            
        });
        
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public LocalTime getTiempoAlarma() {
        return tiempoAlarma;
    }

    public void setTiempoAlarma(LocalTime tiempoAlarma) {
        this.tiempoAlarma = tiempoAlarma;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
    
    
    
    
    
}