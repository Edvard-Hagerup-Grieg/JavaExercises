package Exercises6_1;

import java.util.Stack;

public class UndoableStringBuilder {
    private StringBuilder stringBuilder;
    private Stack<Action> actions = new Stack<>();

    public UndoableStringBuilder(String str) {
        stringBuilder = new StringBuilder(str);
    }

    public UndoableStringBuilder undo() {
        if(!actions.isEmpty()) {
            actions.pop().undo();
        }

        return this;
    }

    public UndoableStringBuilder append(String string) {
        stringBuilder.append(string);

        Action undoAction = () -> stringBuilder.delete(stringBuilder.length() - string.length(), stringBuilder.length());
        actions.push(undoAction);

        return this;
    }

    public UndoableStringBuilder insert(int start, String string) {
        stringBuilder.insert(start, string);

        Action undoAction = () -> stringBuilder.delete(start, start + string.length());
        actions.push(undoAction);

        return this;
    }

    public UndoableStringBuilder replace(int start, int end, String string) {
        String replacedString = stringBuilder.substring(start, end);
        stringBuilder.replace(start, end, string);

        Action undoAction = () -> stringBuilder.replace(start, start + string.length(), replacedString);
        actions.push(undoAction);

        return this;
    }

    public UndoableStringBuilder delete(int start, int end) {
        String deletedString = stringBuilder.substring(start, end);
        stringBuilder.delete(start, end);

        Action undoAction = () -> stringBuilder.insert(start, deletedString);
        actions.push(undoAction);

        return this;
    }

    public UndoableStringBuilder reverse() {
        stringBuilder.reverse();

        Action undoAction = () -> stringBuilder.reverse();
        actions.push(undoAction);

        return this;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
