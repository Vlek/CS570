
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

def mergeSort(x):
    result = []
    if len(x) == 1:
        result.append(x[0])
    else:
        middle = len(x) // 2
        result.extend(merge(mergeSort(x[0:middle]), mergeSort(x[middle:])))
    return result

print(mergeSort([11,9,17,5,12]))
