package com.tsnanh.calculator

import java.util.*


class Calculate(string: String) {

    var result: String

    init {
        result = convertToPostfix(string)
    }

    private fun convertToPostfix(string: String): String {
        var postfix = ""

        val stack: Stack<Char> = Stack()
        var i = 0
            while (i < string.length) {
                while (string[i] == ' ') {
                    ++i
                }
                if (Character.isDigit(string[i])) {
                    postfix += string[i]
                    if (i+1 >= string.length || !Character.isDigit(string[i+1])) {
                        postfix += ' '
                    }
                } else if (isLowerPrecedence(string[i]) != 0) {
                    while (!stack.isEmpty() && isLowerPrecedence(stack.peek()) >= isLowerPrecedence(string[i]) && stack.peek() != '(') {
                        postfix += stack.peek()
                        postfix += ' '
                        stack.pop()
                    }
                    stack.push(string[i])
                } else if (string[i] == '(') {
                    stack.push(string[i])
                } else if (string[i] == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        postfix += stack.peek()
                        stack.pop()
                    }
                    stack.pop()
                }
                i++
            }


        while (stack.isNotEmpty()) {
            postfix += stack.peek()
            postfix += ' '
        }

        return postfix
    }


//    private fun isOperator(string: String): Boolean {
//        return string == "+" || string == "-" || string == "*" || string == "/" || string == "("
//                || string == ")"
//    }

    private fun isLowerPrecedence(op1: Char): Int {
        return when (op1) {
            '+', '-' -> 1
            '*', '/' -> 2
            else -> 1
        }
    }
}