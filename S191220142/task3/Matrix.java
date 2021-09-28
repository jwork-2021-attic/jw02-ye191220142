package S191220142.task3;

public class Matrix {
    class Position {
        private Linable linable;

        Position(Linable linable) {
            this.linable = linable;
        }

        public void setLinable(Linable linable) {
            this.linable = linable;
            linable.setPosition(this);
        }
    }
    private Position[] positions;
    private int row, col;

    public Matrix(int row, int col) {
        this.positions = new Position[row * col];
        this.row = row;
        this.col = col;
    }

    public void put(Linable linable, int row, int col) {
        if (this.positions[row * 16 + col] == null) {
            this.positions[row * 16 + col] = new Position(null);
        }
        this.positions[row * 16 + col].setLinable(linable);
    }

    public Linable get(int row, int col) {
        if ((row < 0) || (col < 0) || (row*16+col > positions.length)) {
            return null;
        } else {
            return positions[row*16+col].linable;
        }
    }

    @Override
    public String toString() {
        String matrixString = "";
        int num = 0;
        for (Position p : positions) {
            matrixString += p.linable.toString();
            num++;
            if(num == col){
                num = 0;
                matrixString += '\n';
            }
        }
        return matrixString;
    }

    public Linable[] toArray() {
        Linable[] linables = new Linable[this.positions.length];

        for (int i = 0; i < linables.length; i++) {
            linables[i] = positions[i].linable;
        }

        return linables;

    }

}
