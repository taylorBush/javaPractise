print("Hello world");

var BigDecimal = Java.type('java.math.BigDecimal');

function calculate(amount, percentage) {
    var result = new BigDecimal(amount).multiply(
        new BigDecimal(percentage)).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_EVEN);

    return result.toPlainString();
}

var result = calculate(48, 13.9);
print(result);