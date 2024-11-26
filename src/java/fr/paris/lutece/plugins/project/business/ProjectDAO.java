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

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.util.ReferenceList;
import fr.paris.lutece.util.sql.DAOUtil;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.paris.lutece.portal.business.file.File;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

/**
 * This class provides Data Access methods for Project objects
 */
public final class ProjectDAO extends AbstractFilterDao implements IProjectDAO
{
    // Constants
    private static final String SQL_QUERY_INSERT = "INSERT INTO project_table ( un_entier, deux_sh, trois_md, quatre_lg, cinq_mail, six_url, sept_date, huit_b, neuf_file ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";
    private static final String SQL_QUERY_DELETE = "DELETE FROM project_table WHERE id_project = ? ";
    private static final String SQL_QUERY_UPDATE = "UPDATE project_table SET un_entier = ?, deux_sh = ?, trois_md = ?, quatre_lg = ?, cinq_mail = ?, six_url = ?, sept_date = ?, huit_b = ?, neuf_file = ? WHERE id_project = ?";
   
	private static final String SQL_QUERY_SELECTALL = "SELECT id_project, un_entier, deux_sh, trois_md, quatre_lg, cinq_mail, six_url, sept_date, huit_b, neuf_file FROM project_table";
    private static final String SQL_QUERY_SELECTALL_ID = "SELECT id_project FROM project_table";

    private static final String SQL_QUERY_SELECTALL_BY_IDS = SQL_QUERY_SELECTALL + " WHERE id_project IN (  ";
	private static final String SQL_QUERY_SELECT_BY_ID = SQL_QUERY_SELECTALL + " WHERE id_project = ?";


	/**
     * Constructor
     */
	public ProjectDAO() {

		initMapSql(Project.class); //Maps with name and type of each databases column associated to the business class attributes 
	}

    /**
     * {@inheritDoc }
     */
    @Override
    public void insert( Project project, Plugin plugin )
    {
        try( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_INSERT, Statement.RETURN_GENERATED_KEYS, plugin ) )
        {
            int nIndex = 1;
            daoUtil.setInt( nIndex++ , project.getUnEntier( ) );
            daoUtil.setString( nIndex++ , project.getDeuxSh( ) );
            daoUtil.setString( nIndex++ , project.getTroisMd( ) );
            daoUtil.setString( nIndex++ , project.getQuatreLg( ) );
            daoUtil.setString( nIndex++ , project.getCinqMail( ) );
            daoUtil.setString( nIndex++ , project.getSixUrl( ) );
            daoUtil.setDate( nIndex++ , project.getSeptDate( ) );
            daoUtil.setBoolean( nIndex++ , project.getHuitB( ) );
            if ( project.getNeufFile( ) != null )
		    {
		    	daoUtil.setString( nIndex++ , project.getNeufFile( ).getFileKey( ) );
		    }
		    else
		    {
		    	daoUtil.setString( nIndex++ , null );
		    }
            
            daoUtil.executeUpdate( );
            if ( daoUtil.nextGeneratedKey( ) ) 
            {
                project.setId( daoUtil.getGeneratedKeyInt( 1 ) );
            }
        }
        
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Optional<Project> load( int nKey, Plugin plugin )
    {
        try( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECT_BY_ID, plugin ) )
        {
	        daoUtil.setInt( 1 , nKey );
	        daoUtil.executeQuery( );
	        Project project = null;
	
	        if ( daoUtil.next( ) )
	        {
	            project = loadFromDaoUtil( daoUtil );
	        }
	
	        return Optional.ofNullable( project );
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void delete( int nKey, Plugin plugin )
    {
        try( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_DELETE, plugin ) )
        {
	        daoUtil.setInt( 1 , nKey );
	        daoUtil.executeUpdate( );
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void store( Project project, Plugin plugin )
    {
        try( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_UPDATE, plugin ) )
        {
	        int nIndex = 1;
	        
            	daoUtil.setInt( nIndex++ , project.getUnEntier( ) );
            	daoUtil.setString( nIndex++ , project.getDeuxSh( ) );
            	daoUtil.setString( nIndex++ , project.getTroisMd( ) );
            	daoUtil.setString( nIndex++ , project.getQuatreLg( ) );
            	daoUtil.setString( nIndex++ , project.getCinqMail( ) );
            	daoUtil.setString( nIndex++ , project.getSixUrl( ) );
            	daoUtil.setDate( nIndex++ , project.getSeptDate( ) );
            	daoUtil.setBoolean( nIndex++ , project.getHuitB( ) );
	        if ( project.getNeufFile( ) != null )
		    {
		    	daoUtil.setString( nIndex++ , project.getNeufFile( ).getFileKey( ) );
		    }
		    else
		    {
		    	daoUtil.setString( nIndex++ , null );
		    }
	        daoUtil.setInt( nIndex , project.getId( ) );
	
	        daoUtil.executeUpdate( );
        }
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public List<Project> selectProjectsList( Plugin plugin )
    {
        List<Project> projectList = new ArrayList<>(  );
        try( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL, plugin ) )
        {
	        daoUtil.executeQuery(  );
	
	        while ( daoUtil.next(  ) )
	        {
				projectList.add( loadFromDaoUtil( daoUtil ) );
	        }
	
	        return projectList;
        }
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public List<Integer> selectIdProjectsList( Plugin plugin,  Map <String,String> mapFilterCriteria, String strColumnToOrder, String strSortMode )
    {
        List<Integer> projectList = new ArrayList<>( );
        
        String strSelectStatement =  prepareSelectStatement(SQL_QUERY_SELECTALL_ID, mapFilterCriteria, strColumnToOrder, strSortMode);  
        
        try( DAOUtil daoUtil = new DAOUtil( strSelectStatement, plugin ) )
        {
        
        	int nIndex = 1;
    	        
   	        for(Map.Entry<String, String> filter : mapFilterCriteria.entrySet()) {
   	        	
   	        	if(StringUtils.isNotBlank(filter.getValue())  && _mapSql.containsKey(filter.getKey())) {
   	        		daoUtil.setString( nIndex++ , filter.getValue() );
   	        	}
   	        }
    	        
	        daoUtil.executeQuery(  );
	
	        while ( daoUtil.next(  ) )
	        {
	            projectList.add( daoUtil.getInt( 1 ) );
	        }
	
	        return projectList;
        }
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public ReferenceList selectProjectsReferenceList( Plugin plugin )
    {
        ReferenceList projectList = new ReferenceList();
        try( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL, plugin ) )
        {
	        daoUtil.executeQuery(  );
	
	        while ( daoUtil.next(  ) )
	        {
	            projectList.addItem( daoUtil.getInt( 1 ) , daoUtil.getString( 2 ) );
	        }
	
	        return projectList;
    	}
    }
    
    /**
     * {@inheritDoc }
     */
	@Override
	public List<Project> selectProjectsListByIds( Plugin plugin, List<Integer> listIds ) {
		List<Project> projectList = new ArrayList<>(  );
		
		StringBuilder builder = new StringBuilder( );

		if ( !listIds.isEmpty( ) )
		{
			for( int i = 0 ; i < listIds.size(); i++ ) {
			    builder.append( "?," );
			}
	
			String placeHolders =  builder.deleteCharAt( builder.length( ) -1 ).toString( );
			String stmt = SQL_QUERY_SELECTALL_BY_IDS + placeHolders + ")";
			
			
	        try ( DAOUtil daoUtil = new DAOUtil( stmt, plugin ) )
	        {
	        	int index = 1;
				for( Integer n : listIds ) {
					daoUtil.setInt(  index++, n ); 
				}
	        	
	        	daoUtil.executeQuery(  );
	        	while ( daoUtil.next(  ) )
		        {
		            projectList.add( loadFromDaoUtil( daoUtil ) );
		        }
	        }
	    }
		return projectList;
		
	}


	private Project loadFromDaoUtil (DAOUtil daoUtil) {
		
		Project project = new Project(  );
		int nIndex = 1;
		
		project.setId( daoUtil.getInt( nIndex++ ) );
		project.setUnEntier( daoUtil.getInt( nIndex++ ) );
		project.setDeuxSh( daoUtil.getString( nIndex++ ) );
		project.setTroisMd( daoUtil.getString( nIndex++ ) );
		project.setQuatreLg( daoUtil.getString( nIndex++ ) );
		project.setCinqMail( daoUtil.getString( nIndex++ ) );
		project.setSixUrl( daoUtil.getString( nIndex++ ) );
		project.setSeptDate( daoUtil.getDate( nIndex++ ) );
		project.setHuitB( daoUtil.getBoolean( nIndex++ ) );
		File fileNeufFile = new File();
		fileNeufFile.setFileKey( daoUtil.getString( nIndex ) );
		project.setNeufFile( fileNeufFile );
		
		return project;
	}
}
