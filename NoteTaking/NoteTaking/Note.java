package learningbuddy.NoteTaking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Note extends JComponent {
    private static final int DEFAULT_WIDTH = 200;
    private static final int DEFAULT_HEIGHT = 100;
    private static final Color EDITABLE_COLOR = Color.WHITE;
    private static final Color NON_EDITABLE_COLOR = Color.LIGHT_GRAY;
    private static final Color BORDER_COLOR = Color.BLACK;

    private JTextArea txtArea;
    private JScrollPane scrollPane;
    private final Point dragOffset = new Point();
    private JButton editButton; // For enabling text editing
    private String text; // Text content of the note
    private Point position; // Position of the note in the Canvas
    private String category; // Category of the note

    // Reference to the Canvas for interaction, like selection
    private Canvas canvas;

    // Default constructor
    public Note() {
        this("", new Point(), ""); // Call the parameterized constructor with default values
    }

    // Parameterized constructor
    public Note(String text, Point position, String category) {
        this.text = text;
        this.position = position;
        this.category = category;
        initializeLayout();
        initializeTextArea();
        initializeEditButton();
        enableDrag();
        addSelectionListener();
    }

    private void initializeLayout() {
        setLayout(new BorderLayout());
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setBackground(NON_EDITABLE_COLOR);
        setBorder(BorderFactory.createLineBorder(BORDER_COLOR));
        setOpaque(true);
    }

    private void initializeTextArea() {
        txtArea = new JTextArea();
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setEditable(false);
        txtArea.setBackground(NON_EDITABLE_COLOR);

        scrollPane = new JScrollPane(txtArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initializeEditButton() {
        editButton = new JButton("Edit");
        editButton.addActionListener(e -> setEditable(true));
        editButton.setFocusPainted(false);
        editButton.setPreferredSize(new Dimension(70, 20));
        editButton.setBorderPainted(false);
        editButton.setOpaque(false);
        editButton.setContentAreaFilled(false);
        add(editButton, BorderLayout.SOUTH);
    }

    private void enableDrag() {
        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dragOffset.x = e.getX();
                dragOffset.y = e.getY();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    setEditable(true);
                }
            }
        };

        txtArea.addMouseListener(ma);
        addMouseListener(ma);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (!txtArea.isEditable()) {
                    Point current = getLocation();
                    int x = current.x - dragOffset.x + e.getX();
                    int y = current.y - dragOffset.y + e.getY();
                    setLocation(x, y);
                    revalidate();
                    repaint();
                }
            }
        });

        txtArea.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                setEditable(false);
            }
        });
    }

    private void setEditable(boolean editable) {
        txtArea.setEditable(editable);
        txtArea.setBackground(editable ? EDITABLE_COLOR : NON_EDITABLE_COLOR);
        editButton.setVisible(!editable); // Hide the button when in edit mode

        if (editable) {
            txtArea.requestFocusInWindow();
        } else {
            // Placeholder for future enhancements, like automatically saving the note.
        }
    }

    public String getText() {
        return txtArea.getText();
    }

    public void setText(String text) {
        txtArea.setText(text != null ? text : "");
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSelected(boolean isSelected) {
        if (isSelected) {
            setBorder(BorderFactory.createLineBorder(Color.BLUE, 2)); // Highlight for selected note
        } else {
            setBorder(BorderFactory.createLineBorder(BORDER_COLOR)); // Default border for unselected note
        }
    }

    private void addSelectionListener() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (canvas != null) {
                    canvas.setCurrentSelectedNote(Note.this);
                }
            }
        });
    }

    // Setter for Canvas reference
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}
