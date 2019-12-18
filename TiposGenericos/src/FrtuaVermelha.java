/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mariana
 */
public class FrtuaVermelha extends Fruta{

    public FrtuaVermelha(String nome) {
        super(nome);
    }
        @Override
    public String toString(){
        return "Fruta (nome="+nome+")";
    }
}
