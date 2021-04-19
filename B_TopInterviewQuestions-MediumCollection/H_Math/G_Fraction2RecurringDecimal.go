package main

import (
	"fmt"
	"strconv"
	"strings"
)

type Divided struct {
	Position  int
	Remainder int
}

func fractionToDecimal(numerator int, denominator int) string {
	isNavigate := false
	if numerator == 0 {
		return "0"
	}
	if numerator < 0 {
		numerator = -numerator
		isNavigate = !isNavigate
	}
	if denominator < 0 {
		denominator = -denominator
		isNavigate = !isNavigate
	}
	digitPlace := make(map[int]Divided, 10)
	integer := numerator / denominator
	decimalSB := strings.Builder{}
	decimal := numerator - integer*denominator
	var decimalStr string
	for decimal > 0 {
		decimal = decimal * 10
		digit := decimal / denominator
		decimal = decimal - digit*denominator
		if divided, ok := digitPlace[digit]; !ok {
			digitPlace[digit] = Divided{
				Position:  decimalSB.Len(),
				Remainder: decimal,
			}
		} else if divided.Remainder == decimal {
			head, _ := digitPlace[digit]
			decimalStr = decimalSB.String()
			decimalStr = decimalStr[:head.Position] + "(" + decimalStr[head.Position:] + ")"
			break
		}
		decimalSB.WriteRune(rune('0' + digit))
	}
	if decimalStr == "" {
		decimalStr = decimalSB.String()
	}
	integerStr := strconv.FormatInt(int64(integer), 10)
	if isNavigate {
		integerStr = "-" + integerStr
	}
	if len(decimalStr) == 0 {
		return integerStr
	} else {
		return integerStr + "." + decimalStr
	}
}

func main() {
	fmt.Println("0.5" == fractionToDecimal(1, 2))
	fmt.Println("2" == fractionToDecimal(2, 1))
	fmt.Println("0.(6)" == fractionToDecimal(2, 3))
	fmt.Println("0.(012)" == fractionToDecimal(4, 333))
	fmt.Println("0.2" == fractionToDecimal(1, 5))
	fmt.Println("0.(003)" == fractionToDecimal(1, 333))
	fmt.Println("-6.25" == fractionToDecimal(-50, 8))
}
