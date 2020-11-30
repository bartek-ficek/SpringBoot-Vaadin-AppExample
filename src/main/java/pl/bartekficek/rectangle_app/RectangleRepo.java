package pl.bartekficek.rectangle_app;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RectangleRepo extends CrudRepository<Rectangle, Long> {

    String PERIMETER = "2 * rect.height + 2 * rect.width";

    @Query(nativeQuery = true, value = "SELECT * FROM RECTANGLE rect WHERE (" + PERIMETER + ">= 20)")
    List<Rectangle> getBigRectangles();

    @Query(nativeQuery = true, value = "SELECT * FROM RECTANGLE rect WHERE " + PERIMETER + " < 20")
    List<Rectangle> getSmallRectangles();
}
