public class BlockReader {
    public static int set(int layer, int code, int cell) {
        cell = clear(layer, cell);
        return cell | (code << layer * 8);
    }
    public static int get(int layer, int cell) {
        return (cell >> 8 * layer ) & 255;
    }
    public static int clear(int layer, int cell) {
        return ~(255 << 8 * layer) & cell;
    }
}
