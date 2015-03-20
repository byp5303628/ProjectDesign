package project.soft.util;

/**
 * Created by ypbai on 2015/3/13.
 */
public class Range<T extends RangeInter<T>> {
   private T start;
   private T end;

   public Range(T start, T end) {
      this.start = start;
      this.end = end;
   }

   public boolean isInRange(T t) {
      int first = t.compareTo(start);
      int second = t.compareTo(end);
      return first >= 0 && second <= 0;
   }

   public T generateRandomItem() {
      return start.generateRandomItem(end);
   }
}
