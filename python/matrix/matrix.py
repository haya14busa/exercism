#!/usr/bin/env python
# -*- coding: utf-8 -*-
# FILE: matrix.py
# AUTHOR: haya14busa
# License: MIT license
#
#     Permission is hereby granted, free of charge, to any person obtaining
#     a copy of this software and associated documentation files (the
#     "Software"), to deal in the Software without restriction, including
#     without limitation the rights to use, copy, modify, merge, publish,
#     distribute, sublicense, and/or sell copies of the Software, and to
#     permit persons to whom the Software is furnished to do so, subject to
#     the following conditions:
#
#     The above copyright notice and this permission notice shall be included
#     in all copies or substantial portions of the Software.
#
#     THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
#     OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
#     MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
#     IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
#     CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
#     TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
#     SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
#
#=============================================================================

class Matrix(object):
    def __init__(self, matrix_string):
        rows_string = map((lambda x: x.strip().split(' ')),
                      matrix_string.split('\n'))
        self.rows = []
        for row_str in rows_string:
            self.rows.append(map(int,row_str))
        self.columns = [ [row[i] for row in self.rows if not row[i] == '']
                         for i in range(len(self.rows) - 1)]

def main():
    m = Matrix('1 2 3\n4 5 6\n7 8 9\n 8 7 6')
    print(m.rows)
    print(m.columns)

if __name__ == '__main__':
    main()
