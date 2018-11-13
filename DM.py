#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Nov  8 16:15:52 2018

@author: alan
"""

from threading import Thread, Condition, current_thread
from tkinter import *
import time
import random


class Fenetre:
    def __init__(self):
        self.fenetre = Tk() 

        self.fileText = StringVar()
        self.prodText = StringVar()
        self.consText = StringVar()

        self.fileL = Label(self.fenetre,textvariable=self.fileText)
        self.prodL = Label(self.fenetre,textvariable=self.prodText)
        self.consL = Label(self.fenetre,textvariable=self.consText)
        
        self.fileText.set("File = <>")
        self.prodText.set("")
        self.consText.set("")

        self.packFen()
        
    def update(self,liste,add=None,rm=None):
        self.fileText.set("File = "+str(liste))
        if add != None:
            self.prodText.set("Producteur : "+str(add)+" a été ajouté")
        if rm != None:
            self.consText.set("Consommateur : "+str(rm)+" a été supprimé")
        self.packFen()

    def packFen(self):
        self.fileL.pack()
        self.prodL.pack()
        self.consL.pack()

class FiFo():
    def __init__(self,fenetre):
        self.liste=[]
        self.cond = Condition()
        self.fenetre = fenetre
        
    def remover(self):
        with self.cond:
            while len(self.liste) == 0:
                self.cond.wait();
            val = self.liste.pop(0)
            self.fenetre.update(self.liste,rm=val)
            self.cond.notifyAll()
        
    def adder(self,v):
        with self.cond:
            while len(self.liste) >= 20:
                self.cond.wait()
            self.liste.append(v)
            self.fenetre.update(self.liste,add=v)
            self.cond.notifyAll()
                        
class ThreadProducteur(Thread):
    
    def __init__(self,fifo):
        Thread.__init__(self)
        self.file = fifo
        self.daemon = True
        
    def run(self):
        while(True):
            v = random.randint(1, 100)
            self.file.adder(v)
            time.sleep(2)
            
            
class ThreadConsommateur(Thread):
    def __init__(self,fifo):
        Thread.__init__(self)
        self.file = fifo 
        self.daemon = True

    def run(self):
        while True:
            self.file.remover()
            time.sleep(4)

if __name__ == "__main__":
    
    f = Fenetre()
    k = FiFo(f)
    p = ThreadProducteur(k)
    c = ThreadConsommateur(k)

    p.start()
    c.start()

    f.fenetre.mainloop()

            
            
        
        
            