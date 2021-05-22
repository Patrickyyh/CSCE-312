from PIL import Image, ImageFont, ImageDraw
W,H = (512,256)
img = Image.new('1',(W,H),color ='white')
draw = ImageDraw.Draw(img)
text = "ATM"

font = ImageFont.truetype("Roboto-Black.ttf",80)
draw.text((40,60),text,font=font)
pixels = img.load()
img.save("atm","PNG")
f = open("aggie.asm","w")


print(pixels[0,0])
for x in range(32): 
    for y in range(H):
        memory = 16384 + 32*y + x
        value = 0
        for z in range(16):
            if pixels[x*16 + z,y] != 255:
                value = value | 2**z
            
        if value != 0:
           if value > 32767:
            #get 32768 into memory
            #load lower 15 bits of value into memory
             
             f.write("@32767\n") 
             f.write("D = A\n")
             f.write("D = D + 1\n")
             f.write(f"@{memory}\n")
             f.write("M = D\n")
             f.write(f"@{value & 32767}\n")
             f.write("D = A\n")
             f.write(f"@{memory}\n")
             f.write("M = M|D\n")

           else:
               f.write(f"@{value}\n")
               f.write("D = A\n")
               f.write(f"@{memory}\n")
               f.write("M = D\n")
f.close()
