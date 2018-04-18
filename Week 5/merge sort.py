
def main(x):
    r = breakDown(x)
    result = []

    for i in r:
        
    return result
    

def merge(a, b):
    result = []
    
    while len(a) or len(b):
        if len(a) and len(b):
            if a[0] < b[0]:
                temp = a.pop(0)
            else:
                temp = b.pop(0)
            result.append(temp)
        else:
            if len(a):
                result.extend(a)
                a = []
            else:
                result.extend(b)
                b = []
    
    return result


def breakDown(x):
    result = []
    if len(x) == 1:
        result.append(x)
    else:
        middle = len(x) // 2
        result.extend(mergeSort(x[0:middle]))
        result.extend(mergeSort(x[middle:]))
    return result


#print(merge([9,11,17],[5,12]))

print(breakDown([11,9,17,5,12]))
