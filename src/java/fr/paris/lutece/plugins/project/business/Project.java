/*
 * Copyright (c) 2002-2024, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.project.business;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.Email;
import java.io.Serializable;
import java.sql.Date;
import javax.validation.constraints.NotNull;
import fr.paris.lutece.portal.business.file.File;
/**
 * This is the business class for the object Project
 */ 
public class Project implements Serializable
{
    private static final long serialVersionUID = 1L;

    // Variables declarations 
    private int _nId;
    
    private int _nUnEntier;
    
    @Size( max = 50 , message = "#i18n{project.validation.project.DeuxSh.size}" ) 
    private String _strDeuxSh;
    
    @Size( max = 255 , message = "#i18n{project.validation.project.TroisMd.size}" ) 
    private String _strTroisMd;
    
    private String _strQuatreLg;
    @Email( message = "#i18n{portal.validation.message.email}" )
    @Size( max = 255 , message = "#i18n{project.validation.project.CinqMail.size}" ) 
    private String _strCinqMail;
    @URL( message = "#i18n{portal.validation.message.url}" )
    @Size( max = 255 , message = "#i18n{project.validation.project.SixUrl.size}" ) 
    private String _strSixUrl;
    @NotNull( message = "#i18n{portal.validation.message.notEmpty}" )
    private Date _dateSeptDate;
    
    private boolean _bHuitB;
    
    private File _fileNeufFile;

    /**
     * Returns the Id
     * @return The Id
     */
    public int getId( )
    {
        return _nId;
    }

    /**
     * Sets the Id
     * @param nId The Id
     */ 
    public void setId( int nId )
    {
        _nId = nId;
    }
    
    /**
     * Returns the UnEntier
     * @return The UnEntier
     */
    public int getUnEntier( )
    {
        return _nUnEntier;
    }

    /**
     * Sets the UnEntier
     * @param nUnEntier The UnEntier
     */ 
    public void setUnEntier( int nUnEntier )
    {
        _nUnEntier = nUnEntier;
    }
    
    
    /**
     * Returns the DeuxSh
     * @return The DeuxSh
     */
    public String getDeuxSh( )
    {
        return _strDeuxSh;
    }

    /**
     * Sets the DeuxSh
     * @param strDeuxSh The DeuxSh
     */ 
    public void setDeuxSh( String strDeuxSh )
    {
        _strDeuxSh = strDeuxSh;
    }
    
    
    /**
     * Returns the TroisMd
     * @return The TroisMd
     */
    public String getTroisMd( )
    {
        return _strTroisMd;
    }

    /**
     * Sets the TroisMd
     * @param strTroisMd The TroisMd
     */ 
    public void setTroisMd( String strTroisMd )
    {
        _strTroisMd = strTroisMd;
    }
    
    
    /**
     * Returns the QuatreLg
     * @return The QuatreLg
     */
    public String getQuatreLg( )
    {
        return _strQuatreLg;
    }

    /**
     * Sets the QuatreLg
     * @param strQuatreLg The QuatreLg
     */ 
    public void setQuatreLg( String strQuatreLg )
    {
        _strQuatreLg = strQuatreLg;
    }
    
    
    /**
     * Returns the CinqMail
     * @return The CinqMail
     */
    public String getCinqMail( )
    {
        return _strCinqMail;
    }

    /**
     * Sets the CinqMail
     * @param strCinqMail The CinqMail
     */ 
    public void setCinqMail( String strCinqMail )
    {
        _strCinqMail = strCinqMail;
    }
    
    
    /**
     * Returns the SixUrl
     * @return The SixUrl
     */
    public String getSixUrl( )
    {
        return _strSixUrl;
    }

    /**
     * Sets the SixUrl
     * @param strSixUrl The SixUrl
     */ 
    public void setSixUrl( String strSixUrl )
    {
        _strSixUrl = strSixUrl;
    }
    
    
    /**
     * Returns the SeptDate
     * @return The SeptDate
     */
    public Date getSeptDate( )
    {
        return _dateSeptDate;
    }

    /**
     * Sets the SeptDate
     * @param dateSeptDate The SeptDate
     */ 
    public void setSeptDate( Date dateSeptDate )
    {
        _dateSeptDate = dateSeptDate;
    }
    
    
    /**
     * Returns the HuitB
     * @return The HuitB
     */
    public boolean getHuitB( )
    {
        return _bHuitB;
    }

    /**
     * Sets the HuitB
     * @param bHuitB The HuitB
     */ 
    public void setHuitB( boolean bHuitB )
    {
        _bHuitB = bHuitB;
    }
    
    
    /**
     * Returns the NeufFile
     * @return The NeufFile
     */
    public File getNeufFile( )
    {
        return _fileNeufFile;
    }

    /**
     * Sets the NeufFile
     * @param fileNeufFile The NeufFile
     */ 
    public void setNeufFile( File fileNeufFile )
    {
        _fileNeufFile = fileNeufFile;
    }
    
}
