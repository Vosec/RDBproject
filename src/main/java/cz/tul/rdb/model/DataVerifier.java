package cz.tul.rdb.model;

import cz.tul.rdb.entity.Jizda;
import java.util.Calendar;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
class DataVerifier {

  /**
   * Verifies if given data are ours
   *
   * @return true if it's our data
   */
  static boolean verifyData(List<Jizda> jizdy) {
    int ourEntityCount = 0; // naše otagované
    int notTaggedCount = 0; // možná naše - nesplňuje podmínku modula
    int threshold = 5; //fixme

    for (Jizda j : jizdy) {
      Calendar cal = Calendar.getInstance();
      cal.setTimeInMillis(j.getCas().getTime());

      int minutes = cal.get(Calendar.MINUTE);
      if (minutes % 10 == 0) {
        int seconds = cal.get(Calendar.SECOND);
        if (seconds == 7 * ((int) (minutes / 10))) {
          ourEntityCount++;
        }
      } else {
        notTaggedCount++;
      }
    }
    threshold = (int)(jizdy.size()*0.3);
    System.out.println(notTaggedCount);
    return (jizdy.size() - (ourEntityCount + notTaggedCount)) < threshold;
  }
}
