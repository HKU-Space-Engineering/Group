package learningbuddy.NoteTaking;

import com.google.gson.Gson;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {
    private final Gson gson = new Gson();
    private Note currentSelectedNote; // Track the currently selected note

    public Canvas() {
        setLayout(null); // Allows for manual positioning of notes
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Deselect current note if click is not on a note
                if (!isClickOnNote(e.getPoint())) {
                    setCurrentSelectedNote(null);
                }
            }
        });
    }

    public Note getCurrentSelectedNote() {
        return currentSelectedNote;
    }

    public void setCurrentSelectedNote(Note note) {
        if (this.currentSelectedNote != null) {
            this.currentSelectedNote.setSelected(false); // Visual indication for deselection
        }
        this.currentSelectedNote = note;
        if (this.currentSelectedNote != null) {
            this.currentSelectedNote.setSelected(true); // Visual indication for selection
        }
        repaint(); // Refresh the UI to reflect the selection change
    }

    private boolean isClickOnNote(Point clickPoint) {
        for (Component comp : getComponents()) {
            if (comp instanceof Note && comp.getBounds().contains(clickPoint)) {
                setCurrentSelectedNote((Note)comp); // Select the note that was clicked
                return true;
            }
        }
        return false;
    }

    public void addNoteToCanvas(Note note) {
        add(note);
        note.setCanvas(this); // Ensure the note is aware of its canvas for interaction
        revalidate();
        repaint();
    }

    // Serialization and other functionality...

    public void saveCanvas(String filePath) {
        List<NoteData> notesData = new ArrayList<>();
        for (Component comp : getComponents()) {
            if (comp instanceof Note note) {
                notesData.add(new NoteData(note.getText(), note.getLocation()));
            }
        }
        String json = gson.toJson(notesData);
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(json);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error occurred while saving the notes: " + e.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Assumes a method to load the canvas from saved state exists

    public void bringToFront(Note note) {
        remove(note);
        add(note, 0); // Add the note to the top of the Z-order
        repaint();
    }

    public void sendToBack(Note note) {
        remove(note);
        add(note, getComponentCount() - 1); // Add the note to the bottom of the Z-order
        repaint();
    }

    public void filterByCategory(String category) {
        for (Component comp : getComponents()) {
            if (comp instanceof Note) {
                Note note = (Note) comp;
                note.setVisible(note.getCategory().equals(category) || category.equals("All"));
            }
        }
    }

    // Helper class to represent note data for serialization
    public static class NoteData {
        public String text;
        public Point position;

        public NoteData(String text, Point position) {
            this.text = text;
            this.position = position;
        }
    }
}
