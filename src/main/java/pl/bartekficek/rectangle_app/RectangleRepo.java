package pl.bartekficek.rectangle_app;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RectangleRepo extends CrudRepository<Rectangle, Long> {

    String PERIMETER = "2 * rect.height + 2 * rect.width";

    @Query(nativeQuery = true, value = "SELECT * FROM RECTANGLE rect WHERE (" + PERIMETER + ">= :rectanglePerimeter)")
    List<Rectangle> getBigRectangles(@Param("rectanglePerimeter") int rectanglePerimeter);

    @Query(nativeQuery = true, value = "SELECT * FROM RECTANGLE rect WHERE " + PERIMETER + " < :rectanglePerimeter")
    List<Rectangle> getSmallRectangles(@Param("rectanglePerimeter") int rectanglePerimeter);
}
