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
 *"
 * License 1.0
 */

package fr.paris.lutece.plugins.project.business;

import fr.paris.lutece.test.LuteceTestCase;

import java.util.Optional;

import java.sql.Date;
import fr.paris.lutece.portal.business.file.File;

/**
 * This is the business class test for the object Project
 */
public class ProjectBusinessTest extends LuteceTestCase
{
    private static final int UNENTIER1 = 1;
    private static final int UNENTIER2 = 2;
    private static final String DEUXSH1 = "DeuxSh1";
    private static final String DEUXSH2 = "DeuxSh2";
    private static final String TROISMD1 = "TroisMd1";
    private static final String TROISMD2 = "TroisMd2";
    private static final String QUATRELG1 = "QuatreLg1";
    private static final String QUATRELG2 = "QuatreLg2";
    private static final String CINQMAIL1 = "CinqMail1";
    private static final String CINQMAIL2 = "CinqMail2";
    private static final String SIXURL1 = "SixUrl1";
    private static final String SIXURL2 = "SixUrl2";
	private static final Date SEPTDATE1 = new Date( 1000000l );
    private static final Date SEPTDATE2 = new Date( 2000000l );
	private static final boolean HUITB1 = true;
    private static final boolean HUITB2 = false;
	private static final File NEUFFILE1 = new File( );
    private static final File NEUFFILE2 = new File( );

	/**
	* test Project
	*/
    public void testBusiness(  )
    {
        // Initialize an object
        Project project = new Project();
        project.setUnEntier( UNENTIER1 );
        project.setDeuxSh( DEUXSH1 );
        project.setTroisMd( TROISMD1 );
        project.setQuatreLg( QUATRELG1 );
        project.setCinqMail( CINQMAIL1 );
        project.setSixUrl( SIXURL1 );
        project.setSeptDate( SEPTDATE1 );
        project.setHuitB( HUITB1 );
        project.setNeufFile( NEUFFILE1 );

        // Create test
        ProjectHome.create( project );
        Optional<Project> optProjectStored = ProjectHome.findByPrimaryKey( project.getId( ) );
        Project projectStored = optProjectStored.orElse( new Project ( ) );
        assertEquals( projectStored.getUnEntier( ) , project.getUnEntier( ) );
        assertEquals( projectStored.getDeuxSh( ) , project.getDeuxSh( ) );
        assertEquals( projectStored.getTroisMd( ) , project.getTroisMd( ) );
        assertEquals( projectStored.getQuatreLg( ) , project.getQuatreLg( ) );
        assertEquals( projectStored.getCinqMail( ) , project.getCinqMail( ) );
        assertEquals( projectStored.getSixUrl( ) , project.getSixUrl( ) );
        assertEquals( projectStored.getSeptDate( ).toString() , project.getSeptDate( ).toString( ) );
        assertEquals( projectStored.getHuitB( ) , project.getHuitB( ) );
        assertEquals( projectStored.getNeufFile( ).getFileKey( ) , project.getNeufFile( ).getFileKey( ) );

        // Update test
        project.setUnEntier( UNENTIER2 );
        project.setDeuxSh( DEUXSH2 );
        project.setTroisMd( TROISMD2 );
        project.setQuatreLg( QUATRELG2 );
        project.setCinqMail( CINQMAIL2 );
        project.setSixUrl( SIXURL2 );
        project.setSeptDate( SEPTDATE2 );
        project.setHuitB( HUITB2 );
        project.setNeufFile( NEUFFILE2 );
        ProjectHome.update( project );
        optProjectStored = ProjectHome.findByPrimaryKey( project.getId( ) );
        projectStored = optProjectStored.orElse( new Project ( ) );
        
        assertEquals( projectStored.getUnEntier( ) , project.getUnEntier( ) );
        assertEquals( projectStored.getDeuxSh( ) , project.getDeuxSh( ) );
        assertEquals( projectStored.getTroisMd( ) , project.getTroisMd( ) );
        assertEquals( projectStored.getQuatreLg( ) , project.getQuatreLg( ) );
        assertEquals( projectStored.getCinqMail( ) , project.getCinqMail( ) );
        assertEquals( projectStored.getSixUrl( ) , project.getSixUrl( ) );
        assertEquals( projectStored.getSeptDate( ).toString( ) , project.getSeptDate( ).toString( ) );
        assertEquals( projectStored.getHuitB( ) , project.getHuitB( ) );
        assertEquals( projectStored.getNeufFile( ).getFileKey( ) , project.getNeufFile( ).getFileKey( ) );

        // List test
        ProjectHome.getProjectsList( );

        // Delete test
        ProjectHome.remove( project.getId( ) );
        optProjectStored = ProjectHome.findByPrimaryKey( project.getId( ) );
        projectStored = optProjectStored.orElse( null );
        assertNull( projectStored );
        
    }
    
    
     

}