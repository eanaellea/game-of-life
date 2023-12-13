package map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class MapTest {
    @Test
    public void testMapSize() {
        Map map = new Map("assets/map1.txt");
        Assertions.assertEquals(10, map.width);
        Assertions.assertEquals(10, map.height);
    }

    @Test
    public void testMapParsing() {
        Map map = new Map("assets/map1.txt");
        Coordinates expectedLiveCell = new Coordinates(0, 0);
        Assertions.assertEquals(1, map.getLiveCells().size());
        Assertions.assertTrue(map.isLiveCell(expectedLiveCell));
    }
}
