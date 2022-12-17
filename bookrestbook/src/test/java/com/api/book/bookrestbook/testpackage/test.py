a=[1,[2,3],4,5]
result = lambda x: list(map(lambda y:2*y, x)) if isinstance(x,list) else lambda x:3*x
print(result(a))