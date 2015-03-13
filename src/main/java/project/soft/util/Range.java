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
      return t.compareTo(start) >= 0 && t.compareTo(end) <= 0;
   }

   public T generateRandomItem() {
      return start.generateRandomItem(end);
   }
}
