package UdemyClone;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class Discount {

    private Database db = new Database(); // Update with your actual database credentials

    // Get discount from the database based on the coupon code
    public double getCouponDiscount(String coupon) {
        String query = "SELECT DISCOUNT_VALUE FROM DISCOUNTS WHERE COUPON_CODE = '" + coupon + "' AND IS_ACTIVE = TRUE AND (EXPIRATION_DATE IS NULL OR EXPIRATION_DATE >= CURDATE())";
        try {
            ResultSet rs = db.Select(query); // Assuming `select` method executes the query and returns a ResultSet
            if (rs.next()) {
                return rs.getDouble("DISCOUNT_VALUE");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0; // Return 0 if no valid coupon is found
    }

    // Get day-based discount (weekend, festival, etc.)
    public double getDayDiscount() {
        LocalDate today = LocalDate.now();
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        double maxDayDiscount = 0.0;

        // Query for day-based discounts (weekends, festivals, etc.)
        String query = "SELECT DISCOUNT_VALUE, DAY_OF_WEEK, START_DATE, END_DATE, FESTIVAL_NAME "
                     + "FROM DISCOUNTS WHERE IS_ACTIVE = TRUE AND DISCOUNT_TYPE = 'day_based'";
        try {
            ResultSet rs = db.Select(query);  // Assuming `select` method executes the query and returns a ResultSet
            while (rs.next()) {
                String dayOfWeekStr = rs.getString("DAY_OF_WEEK");
                String[] days = dayOfWeekStr != null ? dayOfWeekStr.split(",") : new String[]{};
                // Check if today matches the day of week or the festival
                for (String day : days) {
                    if (day.trim().equalsIgnoreCase(dayOfWeek.name())) {
                        maxDayDiscount = Math.max(maxDayDiscount, rs.getDouble("DISCOUNT_VALUE"));
                        break;
                    }
                }
                // Check for festival-based discounts
                Date sqlStartDate = rs.getDate("START_DATE");
                if (sqlStartDate == null) {
                	maxDayDiscount = Math.max(maxDayDiscount, rs.getDouble("DISCOUNT_VALUE"));
                    return maxDayDiscount;
                }
                LocalDate startDate = sqlStartDate.toLocalDate();
                LocalDate endDate = rs.getDate("END_DATE").toLocalDate();
                if (today.isEqual(startDate) || (today.isAfter(startDate) && today.isBefore(endDate))) {
                    maxDayDiscount = Math.max(maxDayDiscount, rs.getDouble("DISCOUNT_VALUE"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxDayDiscount;  // Return the highest applicable day-based discount
    }

    public void displayDiscountInfo() {
        System.out.println("\n===== Current Discounts =====");
        System.out.println("1. Coupon Codes:");
        
        // Display available coupon codes
        String query = "SELECT COUPON_CODE, DISCOUNT_VALUE FROM DISCOUNTS WHERE IS_ACTIVE = TRUE AND DISCOUNT_TYPE = 'coupon'";
        try {
            ResultSet rs = db.Select(query); // Assuming `select` method executes the query and returns a ResultSet
            while (rs.next()) {
                System.out.println("   - " + rs.getString("COUPON_CODE") + ": " + (rs.getDouble("DISCOUNT_VALUE") * 100) + "% off.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Display day-based discounts (weekends, festivals)
        System.out.println("2. Day-based Discounts:");
        query = "SELECT DAY_OF_WEEK, FESTIVAL_NAME, DISCOUNT_VALUE FROM DISCOUNTS WHERE IS_ACTIVE = TRUE AND DISCOUNT_TYPE = 'day_based'";
        try {
            ResultSet rs = db.Select(query);  // Assuming `select` method executes the query and returns a ResultSet
            while (rs.next()) {
                String dayOfWeek = rs.getString("DAY_OF_WEEK");
                String festival = rs.getString("FESTIVAL_NAME");
                double discount = rs.getDouble("DISCOUNT_VALUE");
                if (dayOfWeek != null) {
                    System.out.println("   - " + dayOfWeek + ": " + (discount * 100) + "% off.");
                }
                if (festival != null) {
                    System.out.println("   - Festival (" + festival + "): " + (discount * 100) + "% off.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
