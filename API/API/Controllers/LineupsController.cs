using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using API.Models;

namespace API.Controllers
{
    public class LineupsController : ApiController
    {
        private Entities7 db = new Entities7();

        // GET: api/Lineups
        public IQueryable<LINEUP> GetLINEUPs()
        {
            return db.LINEUPs;
        }

        // GET: api/Lineups/5
        [ResponseType(typeof(LINEUP))]
        public IHttpActionResult GetLINEUP(int id)
        {
            LINEUP lINEUP = db.LINEUPs.Find(id);
            if (lINEUP == null)
            {
                return NotFound();
            }

            return Ok(lINEUP);
        }

        // PUT: api/Lineups/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutLINEUP(int id, LINEUP lINEUP)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != lINEUP.LINEUP_ID)
            {
                return BadRequest();
            }

            db.Entry(lINEUP).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!LINEUPExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/Lineups
        [ResponseType(typeof(LINEUP))]
        public IHttpActionResult PostLINEUP(LINEUP lINEUP)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.LINEUPs.Add(lINEUP);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (LINEUPExists(lINEUP.LINEUP_ID))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = lINEUP.LINEUP_ID }, lINEUP);
        }

        // DELETE: api/Lineups/5
        [ResponseType(typeof(LINEUP))]
        public IHttpActionResult DeleteLINEUP(int id)
        {
            LINEUP lINEUP = db.LINEUPs.Find(id);
            if (lINEUP == null)
            {
                return NotFound();
            }

            db.LINEUPs.Remove(lINEUP);
            db.SaveChanges();

            return Ok(lINEUP);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool LINEUPExists(int id)
        {
            return db.LINEUPs.Count(e => e.LINEUP_ID == id) > 0;
        }
    }
}